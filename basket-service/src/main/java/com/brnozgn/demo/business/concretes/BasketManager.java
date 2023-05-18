package com.brnozgn.demo.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.brnozgn.demo.business.abstracts.BasketService;
import com.brnozgn.demo.business.constants.Messages;
import com.brnozgn.demo.business.dto.requests.CreateBasketRequest;
import com.brnozgn.demo.business.dto.responses.CreateBasketResponse;
import com.brnozgn.demo.business.dto.responses.GetAllBasketResponse;
import com.brnozgn.demo.dataAccess.BasketRepository;
import com.brnozgn.demo.entities.Basket;
import com.brnozgn.demo.events.basket.BookCreatedEvent;
import com.brnozgn.demo.kafka.BasketProducer;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;
import com.brnozgn.demo.utilities.results.SuccessDataResult;
import com.brnozgn.demo.utilities.results.SuccessResult;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BasketManager implements BasketService {

	private BasketRepository repository;
	private ModelMapper mapper;
	private BasketProducer basketProducer;

	@Override
	public DataResult<CreateBasketResponse> add(CreateBasketRequest request) {
		Basket basket = this.mapper.map(request, Basket.class);
		basket.setId(UUID.randomUUID().toString());
		this.repository.save(basket);

		/*BookCreatedEvent bookCreatedEvent = new BookCreatedEvent();
		bookCreatedEvent.setBookId(request.getBookId());
		bookCreatedEvent.setTotalPcs(request.getTotalPcs());
		bookCreatedEvent.setMessages("Basket Created");
		this.basketProducer.sendMessage(bookCreatedEvent);*/

		CreateBasketResponse response = this.mapper.map(basket, CreateBasketResponse.class);
		return new SuccessDataResult<CreateBasketResponse>(response, Messages.CreatedBasket);
	}

	@Override
	public Result delete(String id) {
		this.repository.deleteById(id);

		return new SuccessResult(Messages.DeletedBasket);
	}

	@Override
	public DataResult<List<GetAllBasketResponse>> getAll() {
		List<Basket> baskets = this.repository.findAll();
		List<GetAllBasketResponse> getAll = baskets.stream()
				.map(basket -> this.mapper.map(basket, GetAllBasketResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBasketResponse>>(getAll, Messages.ListedBasket);
	}

}

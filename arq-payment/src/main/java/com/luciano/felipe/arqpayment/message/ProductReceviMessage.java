package com.luciano.felipe.arqpayment.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.luciano.felipe.arqpayment.data.vo.ProductVo;
import com.luciano.felipe.arqpayment.entities.Product;
import com.luciano.felipe.arqpayment.repository.ProductRepository;

@Component
public class ProductReceviMessage {
	
	private final ProductRepository productRepository;

	@Autowired
	public ProductReceviMessage(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@RabbitListener(queues = {"${crud.rabbitmq.queue}"})
	public void toReceive(@Payload ProductVo productVo) {
		productRepository.save(Product.create(productVo));
		
	}

}

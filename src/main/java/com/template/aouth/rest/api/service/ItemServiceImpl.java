package com.template.aouth.rest.api.service;

import com.template.aouth.rest.api.entity.Item;
import com.template.aouth.rest.api.repository.ItemsRepository;
import com.template.aouth.rest.api.repository.ResultPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ItemServiceImpl implements ItemService{

    private ItemsRepository itemsRepository;

    public ItemServiceImpl(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public ResultPage<Item> getItems(int pageNumber, int pageSize) {
        Page<Item> accountsPage = itemsRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(accountsPage.getContent(), accountsPage.getNumber(), accountsPage.getTotalPages());
    }

}

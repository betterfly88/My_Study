package com.betterfly.objectmapping;

import com.betterfly.objectmapping.converter.ModelMapperConverterImpl;
import com.betterfly.objectmapping.converter.OrikaConverterImpl;
import com.betterfly.objectmapping.entity.OrderEntity;
import com.betterfly.objectmapping.mapper.MapStructConverter;
import com.betterfly.objectmapping.model.OrderDto;
import com.betterfly.objectmapping.model.Product;
import com.betterfly.objectmapping.service.MappingService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Starter {
    public static void main(String[] args) {
        MappingService mappingService = new MappingService();

        mappingService.init();
        mappingService.timeCheck();
    }
}

/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.guide.recommend;

import java.util.Arrays;
import java.util.List;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Eric Zhao
 */
@Service
public class RecommendService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecommendService.class);

    @SentinelResource(value = "getRecommendedList", blockHandler = "handleTooManyRequests")
    public List<String> getRecommendedList() {
        return Arrays.asList("T-shirt", "laptop", "books");
    }

    public List<String> handleTooManyRequests(BlockException ex) {
        LOGGER.error("Too many requests: " + ex.getClass().getSimpleName());
        return Arrays.asList("Sentinel robot");
    }
}

/*
 * Copyright (c) 2018 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.javaer.aliyun.spring.boot.autoconfigure.oss;

import com.aliyun.oss.OSSClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cn-src
 */
@Configuration
@ConditionalOnClass({OSSClient.class})
@EnableConfigurationProperties(OssProperties.class)
public class OssAutoConfiguration {

    private final OssProperties ossProperties;

    public OssAutoConfiguration(final OssProperties ossProperties) {
        this.ossProperties = ossProperties;
    }

    @Bean
    public OssClientFactoryBean ossClientFactoryBean() {
        final OssClientFactoryBean factoryBean = new OssClientFactoryBean();
        factoryBean.setEndpoint(this.ossProperties.getEndpoint());
        factoryBean.setAccessKeyId(this.ossProperties.getAccessKeyId());
        factoryBean.setAccessKeySecret(this.ossProperties.getAccessKeySecret());
        return factoryBean;
    }
}

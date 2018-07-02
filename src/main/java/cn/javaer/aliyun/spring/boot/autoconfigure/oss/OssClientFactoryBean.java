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
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * @author cn-src
 */
public class OssClientFactoryBean implements FactoryBean<OSSClient>, InitializingBean, DisposableBean {

    private OSSClient ossClient;
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;

    @Override
    public OSSClient getObject() throws Exception {
        return this.ossClient;
    }

    @Override
    public Class<?> getObjectType() {
        return OSSClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void destroy() throws Exception {
        if (this.ossClient != null) {
            this.ossClient.shutdown();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.endpoint, "'endpoint' must be not null");
        Assert.notNull(this.accessKeyId, "'accessKeyId' must be not null");
        Assert.notNull(this.accessKeySecret, "'accessKeySecret' must be not null");
        this.ossClient = new OSSClient(this.endpoint, this.accessKeyId, this.accessKeySecret);
    }

    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    public void setAccessKeyId(final String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(final String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}

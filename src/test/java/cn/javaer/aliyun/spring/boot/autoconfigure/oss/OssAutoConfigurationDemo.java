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

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * @author zhangpeng
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OssAutoConfiguration.class)
public class OssAutoConfigurationDemo {
    @Autowired
    private OSSClient ossClient;

    @Test
    public void ossClientFactoryBean() throws Exception {
        final String bucketName = "";
        final String fileKey = "";
        final String localFile = "";
        final String downloadFile = "demo.jpg";
        this.ossClient.putObject(bucketName, fileKey, new File(localFile));
        final InputStream inputStream = this.ossClient.getObject(bucketName, fileKey).getObjectContent();
        StreamUtils.copy(inputStream, new FileOutputStream(downloadFile));
        System.out.println(this.ossClient.generatePresignedUrl(bucketName, fileKey, new Date(System.currentTimeMillis() + (1000 * 30)), HttpMethod.GET).toString());
//        this.ossClient.deleteObject(bucketName, fileKey);
    }
}
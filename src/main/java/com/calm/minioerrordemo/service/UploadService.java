package com.calm.minioerrordemo.service;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * upload  object service.
 *
 * @author calm on 2020-12-29
 * @since 1.0.0
 **/
@Service
public class UploadService {

    @Value("${minio.targetBucket}")
    private String targetBucket;

    @Resource
   private MinioClient minioClient;

    public String upload() {
        ClassPathResource testFileResource = new ClassPathResource("wagon-http-3.2.0-shaded.jar");
        try(InputStream in = testFileResource.getInputStream()) {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(targetBucket)
                            .object(UUID.randomUUID() + "/" + testFileResource.getFilename())
                            .stream(in, testFileResource.getFile().length(), -1)
                            .contentType("application/x-shar")
                    .build()
            );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlParserException e) {
            e.printStackTrace();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InsufficientDataException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidResponseException e) {
            e.printStackTrace();
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (InternalException e) {
            e.printStackTrace();
        }
        return "success";
    }

}

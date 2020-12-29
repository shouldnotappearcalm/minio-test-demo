# Minio-Test-Demo SpringBoot

## Version

Minio Client 8.0.3

## Minio Server Log

minio.log is minio log file

## If You Want Test

If you want to test upload files to minio,you should modify `src/main/resources/application.yml` to your own configuration

And use SpringBoot Application start way to start it,call `http://ip:8080/upload` will upload `resources/wagon-http-3.2.0-shaded.jar` to `bucket/{randomUUID}/wagon-http-3.2.0-shaded.jar`

#config
IMAGE=iotportal/sdf-basic-micro
VERSION=latest
PORT=9881
REDIS_HOST=127.0.0.1
REDIS_PASSWORD=""
REDIS_PORT=6379
MINIO_HOST=http://172.17.0.2:9000
MINIO_USERNAME=minio_root
MINIO_PASSWORD=minio_root
BASIC_HOST=https://sdf-micro-app-admin.wgine-daily.com:7799/
BASIC_CODE=testdevelopercode
BASIC_KEY=tuyasecretkey
PUBLIC_KEY=MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDnX0b4BIpZshnV4rvKbgeNmjeobDrwG9xzURA+11cjnEK/r0riLQ+jNw5bJ1CXnETpDkIOvZlmYSKrovWImw7gc4M+YJIPkcdyuurWW/Y88CCAb9VxlaMU4xXzWbauvuLZZhKtjr0nS+Ii73ye1O5SF0aA1EVjnGmIGrN+QbWCpwIDAQAB

base_dir=$(cd "$(dirname "$0")";pwd)

app_path=$base_dir/app/$IMAGE

#pull image
docker pull $IMAGE:$VERSION

mkdir -p $app_path
touch $app_path/api_stdout.log

#run
docker run -d \
-p $PORT:$PORT \
--env PORT=$PORT \
--network host \
-v $app_path/api_stdout.log:/data/app/logs/api_stdout.log \
--env REDIS_HOST=$REDIS_HOST \
--env REDIS_PASSWORD=$REDIS_PASSWORD \
--env REDIS_PORT=$REDIS_PORT \
--env MINIO_HOST=$MINIO_HOST \
--env MINIO_USERNAME=$MINIO_USERNAME \
--env MINIO_PASSWORD=$MINIO_PASSWORD \
--env BASIC_HOST=$BASIC_HOST \
--env BASIC_CODE=$BASIC_CODE \
--env BASIC_KEY=$BASIC_KEY \
--env PUBLIC_KEY=$PUBLIC_KEY \
--name sdf-basic-micro \
$IMAGE:$VERSION
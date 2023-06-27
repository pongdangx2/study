# Redis
### Redis 설치

1. Mac에서 redis 설치

>$brew install redis

2. redis 서비스 시작

> $brew services start redis

3. redis 서비스 종료

> $brew services stop redis

4. redis 서비스 재기동

> $brew services restart redis

<hr>

### Redis requirepass 설정
> redis-cli -p 6379
> config get requirepass
> config set requirdpass <password>

<hr>

# Service Monitor

## Описание
Учебное приложение для мониторинга доступности сервисов.

## Запуск
1. docker compose up -d
2. mvn spring-boot:run

## Авторизация
Basic Auth
login: admin
password: admin

## API
POST /api/admin/services
GET /api/metrics/availability
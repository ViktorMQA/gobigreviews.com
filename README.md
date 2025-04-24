mvn test -Dtest=SignUpTests
mvn test -Dtest=tests.*

# генерація alure звіта
allure serve allure-results

# запуск ткстів з урахуванням енва
mvn test -DENV=prod


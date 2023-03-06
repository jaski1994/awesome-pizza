# awesome-pizza
managing pizza order with framework spring

## set data
curl http://localhost:8080/pizza -d name=marinara -d descrizione=pomodoro
curl http://localhost:8080/user -d name=luca -d email=luca@gmail.com
curl http://localhost:8080/order -d name=marinara -d user=luca


## get data
curl http://localhost:8080/allorders
curl http://localhost:8080/allpizza
curl http://localhost:8080/allorders


## other operation

### make pizza
curl http://localhost:8080/make
### complete pizza and set notification
curl http://localhost:8080/complete
### reset notification
curl http://localhost:8080/notification -d user=luca

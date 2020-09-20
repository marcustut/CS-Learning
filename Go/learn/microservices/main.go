package main

import (
	"handlers"
	"log"
	"net/http"
	"os"
)

func main() {
	logObj := log.New(os.Stdout, "product-api", log.LstdFlags)

	helloHandler := handlers.NewHello(logObj)
	goodbyeHandler := handlers.NewGoodbye(logObj)

	serveMux := http.NewServeMux()
	serveMux.Handle("/", helloHandler)
	serveMux.Handle("/goodbye", goodbyeHandler)

	http.ListenAndServe(":9090", serveMux)
}

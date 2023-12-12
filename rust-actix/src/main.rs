use actix_web::{get, web, App, HttpServer, Responder};
use serde::Serialize;

#[derive(Serialize)]
struct Message {
    hello: String,
}

#[get("/")]
async fn greet() -> impl Responder {
    web::Json(Message { hello: "world".to_string() })
}

#[actix_web::main] // or #[tokio::main]
async fn main() -> std::io::Result<()> {
    HttpServer::new(|| {
        App::new().service(greet)
    })
    .bind(("127.0.0.1", 6000))?
    .run()
    .await
}
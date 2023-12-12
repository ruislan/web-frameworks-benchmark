use ntex::web;
use serde::Serialize;

#[derive(Serialize)]
struct Message {
    hello: String,
}

#[web::get("/")]
async fn hello() -> impl web::Responder {
    web::types::Json(Message { hello: "world".to_string()})
}

#[ntex::main]
async fn main() -> std::io::Result<()> {
    web::HttpServer::new(|| {
        web::App::new().service(hello)
    })
    .bind(("127.0.0.1", 6000))?
    .run()
    .await
}
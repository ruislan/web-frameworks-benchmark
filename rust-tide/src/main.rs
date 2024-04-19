use tide::{Body, Request, Response};
use tide::prelude::*;

#[derive(Serialize)]
struct Message {
    hello: String,
}

#[async_std::main]
async fn main() -> tide::Result<()> {
    let mut app = tide::new();
    app.at("/").get(say_hello);
    app.listen("127.0.0.1:6000").await?;
    Ok(())
}

async fn say_hello(_req: Request<()>) -> tide::Result {
    let mut res = Response::new(200);
    res.set_body(Body::from_json(&Message { hello: "world".to_string()})?);
    Ok(res)
}
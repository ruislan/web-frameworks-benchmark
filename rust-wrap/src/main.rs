use warp::Filter;

#[tokio::main]
async fn main() {
    let hello = warp::any()
        .map(|| "{ hello: world }".to_string());

    warp::serve(hello)
        .run(([127, 0, 0, 1], 6000))
        .await;
}
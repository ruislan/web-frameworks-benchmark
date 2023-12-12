#[macro_use]
extern crate rocket;
use rocket::http::Status;
use rocket::response::{content, status};

#[get("/")]
fn json() -> status::Custom<content::RawJson<&'static str>> {
    status::Custom(Status::ImATeapot, content::RawJson("{ \"hello\": \"world\" }"))
}
#[launch]
fn rocket() -> _ {
    rocket::build().mount("/", routes![json])
}
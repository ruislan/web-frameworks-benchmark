const std = @import("std");
const zap = @import("zap");

fn on_request(r: zap.SimpleRequest) void {
    var json_to_send: []const u8 = "{\"hello\": \"world\"}";
    r.setContentType(.JSON) catch return;
    r.sendBody(json_to_send) catch return;
}

pub fn main() !void {
    var listener = zap.SimpleHttpListener.init(.{
        .port = 6000,
        .on_request = on_request,
        .log = false,
    });
    try listener.listen();

    std.debug.print("Listening on 0.0.0.0:6000", .{});

    // start worker threads
    zap.start(.{
        .threads = 2,
        .workers = 2,
    });
}

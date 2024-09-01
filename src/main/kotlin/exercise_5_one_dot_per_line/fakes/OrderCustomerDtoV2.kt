package exercise_5_one_dot_per_line.fakes

class OrderCustomerDtoV2(
    var id: String,
    var storeName: String,
    var phone: String,
    var shippingAddress: String,
    var shippingAddressId: String,
    var zoneInfo: ZoneInfoDto = ZoneInfoDto("", "", "", ""),
    var customerChannel: String
)
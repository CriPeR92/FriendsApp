package com.example.randomfriends.model

import com.google.gson.annotations.SerializedName

/**
 * Main model response from randomUsers API
 */
class FriendsResponse(
    @SerializedName("results") var results: ArrayList<User>,
    @SerializedName("info") var info: Info
)

class Info(
    @SerializedName("seed") var seed: String?,
    @SerializedName("results") var results: Int?,
    @SerializedName("page") var page: Int?,
    @SerializedName("version") var version: String?
)

class Name(
    @SerializedName("title") var title: String?,
    @SerializedName("first") var first: String?,
    @SerializedName("last") var last: String?
)

class Picture(
    @SerializedName("large") var large: String?,
    @SerializedName("medium") var medium: String?,
    @SerializedName("thumbnail") var thumbnail: String?,
)

class Id(
    @SerializedName("name") var name: String?,
    @SerializedName("value") var value: String?
)

class Street(
    @SerializedName("number") var number: Int?,
    @SerializedName("name") var name: String?
)

class Location(
    @SerializedName("street") var street: Street?,
    @SerializedName("city") var city: Any?,
    @SerializedName("state") var state: Any?,
    @SerializedName("country") var country: String?,
    @SerializedName("postcode") var postcode: Any?,
    @SerializedName("coordinates") var coordinates: Any?,
    @SerializedName("timezone") var timezone: Any?
)

class User(
    @SerializedName("gender") var gender: String?,
    @SerializedName("name") var name: Name?,
    @SerializedName("location") var location: Location?,
    @SerializedName("email") var email: String?,
    @SerializedName("login") var login: Any?,
    @SerializedName("dob") var dob: Any?,
    @SerializedName("registered") var registered: Any?,
    @SerializedName("phone") var phone: String?,
    @SerializedName("cell") var cell: String?,
    @SerializedName("id") var id: Id?,
    @SerializedName("picture") var picture: Picture?,
    @SerializedName("nat") var nat: String?,
)
if ( api.global["count"] == null ) {
    api.global["count"] = 0
}
api.trace("I see counter before:",api.global["count"]?:"Empty" )
api.global["count"] = api.global["count"]+input.Quantity?:0
api.trace("I see counter after:",api.global["count"] )

return api.global["count"]

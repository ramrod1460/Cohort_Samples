api.global.computeIfAbsent("CountryInfo") {
    api.trace("Need to store")
    return api.findLookupTableValues("Country")
            .collectEntries {
                [(it.name): it.value]
            }
}
return api.global.get("CountryInfo")
// Retrieve the value from cache using: 'api.global.Country'

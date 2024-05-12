api.global.computeIfAbsent("CountryInfo") {
    api.trace("Storing missing value")
    return api.findLookupTableValues("CountryInfo")
            .collectEntries {
                [(it.name): it.value]
            }
}

// Retrieve the value from cache using: 'api.global.Country'

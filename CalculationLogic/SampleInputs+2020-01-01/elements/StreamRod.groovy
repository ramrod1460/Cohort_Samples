def filters = [
        Filter.equal("name", "SomeName"),
        Filter.equal("sku", sku),
]

def records = api.stream("PX", null, *filters)
        ?.withCloseable { it.collect()
        }

def ctx = api.getDatamartContext()
def dm = ctx.getDatamart("Transaction")
def filters = [
        Filter.equal("ProductId","MB-0001"),
        //Filter.equal("InvoiceDateMonth","2022-M11"),
        Filter.equal("InvoiceDateYear","2022"),
]
def query = ctx.newQuery(dm, true)
        .select("ProductId")
        .select("SUM(Quantity)" , "TotalQuantity")
query.where(*filters)
//query.orderBy("ProductId")
//query.orderBy("TotalQuantity")

def result = ctx.executeQuery(query)
def x = result?.getData()
api.trace("result 1:",x[0].ProductId)
//api.trace("result 2:",x.get(0))
//api.trace("result value:",result?.get(0))


for (def r=0; r < result.data.getRowCount(); r++){
    def row = result.data.getRowValues(r)    // row #r as map
    api.trace("query", "row $r", row)
}


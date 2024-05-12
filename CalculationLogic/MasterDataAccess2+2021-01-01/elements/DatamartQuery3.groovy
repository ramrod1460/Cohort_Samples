def filters = [
        Filter.equal("ProductId","MB-0001"),
        //Filter.equal("InvoiceDateMonth","2022-M11"),
        Filter.equal("InvoiceDateYear","2022"),
]

def ctx = api.getDatamartContext()

def dm = ctx.getDatamart("Transaction")

def query = ctx.newQuery(dm, true)
        .select("ProductId")
        .select("Quantity")
        .select("SUM(Quantity)","Totals")
         query.where(*filters)
        .orderBy("ProductId")

def result = ctx.executeQuery(query)
api.trace("result:",result?.getData())

/**
 for (def row : result?.getData()) {
 api.trace("Hit", row.ProductId+" / "+row.ResultPrice)
 }
 */
result?.getData()?.forEach {row ->
    api.trace("I see product : "+row.ProductId+" Quantity : "+row.Totals)
}

def resultM = result?.data?.toResultMatrix()
api.trace("ResultM", resultM)

def resultMD = result?.data?.getValue(0, 1)
api.trace("ResultMD", resultMD)


def ctx = api.getDatamartContext()

def dm = ctx.getDatamart("SalesTransactions")

def query = ctx.newQuery(dm, true)
        .select("ProductGroup")
        .select("SUM(SalesValue)", "SalesValue")
        .where(
                Filter.equal("Year", "2024"),
        )
        .orderBy("ProductGroup")

def result = ctx.executeQuery(query)

result?.getData()?.collect {
    // TODO: add your code here
    it
}

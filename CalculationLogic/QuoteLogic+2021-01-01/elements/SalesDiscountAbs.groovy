if (out.ListPrice == null ||
        out.SalesDiscountPct == null) {
    api.addWarning("Sales Discount cannot be calculated: missing parameter(s)")
    return null
}
api.trace("SalesDiscountPct:"+out.SalesDiscountPct)
api.trace("List Price:"+out.ListPrice)

return out.ListPrice * out.SalesDiscountPct

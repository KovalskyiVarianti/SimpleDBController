package specification

class SelectAllClothesSpecification : SqlSpecification, ReturnableSpecification {
    override fun toSqlQuery(): String =
        "SELECT * FROM clothes;"
}
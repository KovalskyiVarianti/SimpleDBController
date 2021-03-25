package repository

import specification.ReturnableSpecification
import specification.Specification
import javax.swing.text.html.parser.Entity

interface Repository<T :Entity> {
    fun add(item: T)
    fun remove(fieldName: String, fieldValue: String)
    fun update(item: T)
    fun showAll(): List<String>
    fun <S : Specification<T>> query(specification: S)
    fun <S : ReturnableSpecification<T>> query(returnableSpecification: S): List<String>

}
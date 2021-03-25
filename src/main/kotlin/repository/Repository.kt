package repository

import specification.ReturnableSpecification
import specification.Specification

interface Repository<T> {
    fun add(item: T)
    fun remove(fieldName: String, fieldValue: String)
    fun update(item: T)
    fun showAll(): Collection<T>
    fun <S : Specification<T>> query(specification: S)
    fun <S : ReturnableSpecification<T>> query(returnableSpecification: S): Collection<T>
    fun List<String>.toEntities(): Collection<T>
}
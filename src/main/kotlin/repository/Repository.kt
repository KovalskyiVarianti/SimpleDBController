package repository

import specification.ReturnableSpecification

interface Repository<T> {
    fun add(item: T)
    fun remove(id: Int)
    fun update(item: T)
    fun query(returnableSpecification: ReturnableSpecification): List<T>
}
package repository

import specification.Specification

interface Repository<T> {
    fun add(item: T)
    fun remove(specification: Specification)
    fun query(specification: Specification): List<T>
}
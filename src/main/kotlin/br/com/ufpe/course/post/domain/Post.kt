package br.com.ufpe.course.post.domain

import br.com.ufpe.course.UnprocessableEntity
import br.com.ufpe.course.user.domain.User
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.SEQUENCE
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Post(
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="POST_SEQUENCE")
    @GenericGenerator(
        name="POST_SEQUENCE",
        strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters=[
            Parameter(name = "increment_size", value = "1")
        ]
    )
    val id: Int? = null,
    val description: String,
    @ManyToOne
    val user: User
) {
    fun toFilter(): PostFilter = this.copy()
        .let {
            PostFilter(
                (it.id ?: UnprocessableEntity("Post id returning null from database!")) as Int,
                it.description,
                it.user
            )
        }
}
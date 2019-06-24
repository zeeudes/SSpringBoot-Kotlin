package br.com.ufpe.course.user.domain

import br.com.ufpe.course.UnprocessableEntity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.time.ZonedDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.SEQUENCE
import javax.persistence.Id

@ApiModel(description="User of system")
@Entity
data class User(
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="USER_SEQUENCE")
    @GenericGenerator(
        name="USER_SEQUENCE",
        strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters=[
            Parameter(name = "increment_size", value = "1")
        ]
    )
    val id: Int? = null,
    @ApiModelProperty(notes="Name of user")
    val name: String,
    @ApiModelProperty(notes="Birth date")
    val birthDate: ZonedDateTime,
    val isDeleted: Boolean
) {
    fun toFilter() = this.copy()
        .let {
            UserFilter(
                (it.id ?: UnprocessableEntity("User id returning null from database!")) as Int,
                it.name,
                it.birthDate,
                it.isDeleted
            )
        }
}
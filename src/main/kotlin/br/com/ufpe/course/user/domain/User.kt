package br.com.ufpe.course.user.domain

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.ZonedDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@ApiModel(description="User of system")
@Entity
data class User(
    @Id
    @GeneratedValue
    val id: Int? = null,
    @ApiModelProperty(notes="Name of user")
    val name: String,
    @ApiModelProperty(notes="Birth date")
    val birthDate: ZonedDateTime
)
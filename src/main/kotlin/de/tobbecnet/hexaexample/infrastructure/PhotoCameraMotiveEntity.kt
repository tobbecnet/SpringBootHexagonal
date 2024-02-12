package de.tobbecnet.hexaexample.infrastructure

import jakarta.persistence.*
import java.util.*


// We start using a general approach containing 3:2 images (photo camera format)
// One motive entity must contain the same picture in different resolutions: Thumbnail, Full
// Other entities should use this with @OneToOne or @OneToMany unidirectional, so an
// intermediate table is created: There is no @ManyToOne in here to refer to a certain entity.
// More image sizes examples: https://www.shopify.com/blog/image-sizes

@Entity
class PhotoCameraMotiveEntity {

    @Id
    val id: UUID = UUID.randomUUID()

    @Column
    val type: String = "default"

    @Lob
    @Column
    @Basic(fetch=FetchType.LAZY)            // Does not work without byte code manipulation
    // 300x200
    var jpgSmall: ByteArray? = null

    @Lob
    @Column
    @Basic(fetch=FetchType.LAZY)            // Checkout if enableLazyInitialization does anything in spring boot 3
    // 600x400
    var jpgMedium: ByteArray? = null

    @Lob
    @Column
    @Basic(fetch=FetchType.LAZY)            // If it does not work, do this https://thorben-janssen.com/lazy-load-non-relational-attributes/
    // 1200x800
    var jpgLarge: ByteArray? = null
}
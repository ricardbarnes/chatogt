package cat.vonblum.chatogt.shared.domain.annotation

/**
 * Marker annotation for driver adapters (AKA "primary")
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class DriverAdapter

package tcj.task.network

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class AllDataResponse(
    @SerializedName("status") val status : Boolean,
    @SerializedName("message") val message : String,
    @SerializedName("data") val data : List<AllApiData>
)

@Entity
data class AllApiData(

    @PrimaryKey
    @SerializedName("id") val id : String,
    
    @SerializedName("first_name") val firstName : String,
    @SerializedName("last_name") val lastName : String,
    @SerializedName("phone") val phone : String,
    @SerializedName("addressLine1") val addressLine1 : String
)
package frame;

import com.example.data.BaseInfo;
import com.example.data.CourseListInfo;
import com.example.data.DataGroupListEntity;
import com.example.data.IndexCommondEntity;
import com.example.data.LoginInfo;
import com.example.data.MainAdEntity;
import com.example.data.PersonHeader;
import com.example.data.SpecialtyChooseEntity;
import com.example.data.TestInfo;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by 任小龙 on 2020/5/28.
 */
public interface IService {
    @GET
    Observable<BaseInfo<MainAdEntity>> getAdvert(@Url String url,@QueryMap Map<String, Object> pMap);
    @GET("/")
    Observable<TestInfo> getTestData(@QueryMap Map<String, Object> params, @Query("page_id") int pageId);
    @GET()
    Observable<BaseInfo<List<SpecialtyChooseEntity>>> getSubjectList(@Url String url);

    @GET("loginByMobileCode")
    Observable<BaseInfo<String>> getLoginVerify(@Query("mobile") String mobile);

    @GET("loginByMobileCode")
    Observable<BaseInfo<LoginInfo>> loginByVerify(@QueryMap Map<String, Object> params);

    @POST
    @FormUrlEncoded
    Observable<BaseInfo<PersonHeader>> getHeaderInfo(@Url String url,@FieldMap Map<String, Object> params);
    @GET
    Observable<BaseInfo<List<IndexCommondEntity>>> getCommonList(@Url String url, @QueryMap Map<String,Object> params);
    @GET
    Observable<JsonObject> getBannerLive(@Url String url, @QueryMap Map<String,Object> params);
//    @GET//课程训练营
    @GET
    Observable<BaseInfo<CourseListInfo>>getCourseChildData(@Url String url, @QueryMap Map<String,Object>map);
    @GET
    Observable<BaseInfo<List<DataGroupListEntity>>>getGroupList(@Url String url, @QueryMap Map<String,Object> params);
    @POST
    @FormUrlEncoded
    Observable<BaseInfo>removeFocus(@Url String url, @FieldMap Map<String,Object> params);
    @POST
    @FormUrlEncoded
    Observable<BaseInfo>joinFocus(@Url String url,@FieldMap Map<String,Object> params);
}

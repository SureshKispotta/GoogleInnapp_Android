# GoogleInnapp_Android
Android inApp purchase(Google) helper for handeling the google inapp process incluiding subscription
</br>
<h5>SetUp : </br>
 Addition in application class</h5>
 </br>
 public class ApplicationApp extends Application</br>
 { </br>
    @Override </br>
    public void onCreate() { </br>
        super.onCreate(); </br>
        //Init sdk before use it </br>
        InnAppSdk.init(this,"Your 64 base Key!"); //64 base key you will get it from play console </br>
    } </br>
}</br>
<h5>Use Case :</h5>
 </br>
  //Let sdk to handel the call back data from the inapp Sercvice of Google in your Activity</br>
    @Override</br>
    protected void onActivityResult(int requestCode, int resultCode, Intent data)</br>
    {</br>
        if(!InnAppSdk.getVendor().onActivity_result(requestCode,resultCode,data))</br>
        {</br>
            super.onActivityResult(requestCode, resultCode, data);</br>
        }</br>
    }</br>
<h5>Purchase item:</h5></br>
//Purchase Management Product id and Subscription id</br>
    public void purchaseInapId(String productId,String payload)</br>
    {</br>
         //Change the Type for INNAPP or SUB according your requirement</br>
        InnAppSdk.getVendor().purchasedItem(this, productId, InnAppSdk.Type.INNAPP,payload, new InAppCallBack.OnPurchased()</br>
        {</br>
            @Override</br>
            public void onSuccess(String productId)</br>
            {</br>
                //onSuccess  on Purchase</br>
            }</br>
            @Override</br>
            public void onError(String id, String error)</br>
            {</br>
                //Error on Purchase</br>
            }</br>
        });</br>
    }

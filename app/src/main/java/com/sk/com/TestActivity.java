package com.sk.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.suresh.innapp_purches.InAppCallBack;
import com.suresh.innapp_purches.InnAppSdk;
import com.suresh.innapp_purches.SkuDetails;
import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity
{
    EditText user_text;
    Button subscribe,purchase;
    String pay_load="qerats12"; //Pay load can be any thing , User id or Secret id
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        user_text=findViewById(R.id.user_text);
        subscribe=findViewById(R.id.subscribe);
        subscribe.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(user_text.getText().length()>0)
                {
                    subScribeInapId(user_text.getText().toString(),pay_load);
                }
            }
        });
        purchase=findViewById(R.id.purchase);
        purchase.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(user_text.getText().length()>0)
                {
                    purchaseInapId(user_text.getText().toString(),pay_load);
                }
            }
        });
    }


    //Let sdk to handel the call back data from the inapp Sercvice of Google
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(!InnAppSdk.getVendor().onActivity_result(requestCode,resultCode,data))
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    //Purchase Management Product id
    public void purchaseInapId(String productId,String payload)
    {
        InnAppSdk.getVendor().purchasedItem(this, productId, InnAppSdk.Type.INNAPP,payload, new InAppCallBack.OnPurchased()
        {
            @Override
            public void onSuccess(String productId)
            {
                //onSuccess  on Purchase
            }
            @Override
            public void onError(String id, String error)
            {
                //Error on Purchase
            }
        });
    }

//Purchase subscription id from here
    public void subScribeInapId(String productId,String payload)
    {
        InnAppSdk.getVendor().purchasedItem(this, productId, InnAppSdk.Type.SUB,payload, new InAppCallBack.OnPurchased()
        {
            @Override
            public void onSuccess(String productId)
            {
                //onSuccess  on Subscription
            }
            @Override
            public void onError(String id, String error)
            {
                //Error on Subscription
            }
        });
    }



    //Getting all the details of all sub the product details.
    private void getAllSubscriptionProductDetails()
    {
        List<String> actual_ids=new ArrayList<>();
        actual_ids.add("com.subscription.id"); //com.subscription.id use your subscription product id
        actual_ids.add("com.subscription.id");//com.subscription.id use your subscription product id
        actual_ids.add("com.subscription.id");//com.subscription.id use your subscription product id
        InnAppSdk.getVendor().getProductDetails(this,actual_ids, InnAppSdk.Type.SUB, new InAppCallBack.DetailsCallback()
        {
            @Override
            public void onSuccess(List<SkuDetails> list, List<String> errorList)
            {
                if(list.size()>0)
                {
                    //you got all suc ess details of the given product  loop through it
                    list.get(0).getProductId();
                    list.get(0).getDescription();
                    list.get(0).getCurrency();
                    list.get(0).getPriceLong();
                    list.get(0).getPriceText();
                    list.get(0).getPriceValue();

                }else
                {
                    //Check error list for message
                }
            }
        });
    }

    //Getting all the details of all INNAPP the product details.

    private void getAllINAPPProductDetails()
    {
        List<String> actual_ids=new ArrayList<>();
        actual_ids.add("com.subscription.id"); //com.subscription.id use your INAPP product id
        actual_ids.add("com.subscription.id");//com.subscription.id use your INAPP product id
        actual_ids.add("com.subscription.id");//com.subscription.id use your INAPP product id
        InnAppSdk.getVendor().getProductDetails(this,actual_ids, InnAppSdk.Type.INNAPP, new InAppCallBack.DetailsCallback()
        {
            @Override
            public void onSuccess(List<SkuDetails> list, List<String> errorList)
            {
                if(list.size()>0)
                {
                    //you got all suc ess details of the given product  loop through it
                    list.get(0).getProductId();
                    list.get(0).getDescription();
                    list.get(0).getCurrency();
                    list.get(0).getPriceLong();
                    list.get(0).getPriceText();
                    list.get(0).getPriceValue();

                }else
                {
                    //Check error list for message
                }
            }
        });
    }

}

package com.rizaldev.debtcollector.screens.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rizaldev.debtcollector.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @BindView(R.id.banner_slider1)
    BannerSlider bannerSlider;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        List<Banner> banners = new ArrayList<>();
        //add banner using image url
        banners.add(new DrawableBanner(R.drawable.adira_dkag));
        banners.add(new DrawableBanner(R.drawable.bfi_dkag));
        banners.add(new DrawableBanner(R.drawable.pegadian_dkag));
        banners.add(new DrawableBanner(R.drawable.prudential_dkag));
        banners.add(new DrawableBanner(R.drawable.tokopedia_dkag));

        for (int i = 0; i < banners.size(); i++) {
            banners.get(i).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        bannerSlider.setBanners(banners);
    }
}

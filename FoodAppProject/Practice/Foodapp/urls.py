
from django.urls import path
from . import views


app_name='Foodapp'
urlpatterns = [
    path('', views.index,name='index'),
    path('<int:item_id>/',views.detail,name='detail'),
    path('hello/', views.hello),
    path('add/',views.create_item,name='create_item'),
    path('update/<int:id>/',views.update_item,name='update'),
    path('delete/<int:id>/',views.delete_item,name='delete'),
]
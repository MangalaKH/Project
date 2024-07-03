from django.db import models


# Create your models here.

class Item(models.Model):
    def __str__(self):
        return self.item_name
    item_name=models.CharField(max_length=122,null=True, blank=True)
    item_desc=models.CharField(max_length=122,null=True, blank=True)
    item_price=models.IntegerField(null=True, blank=True)
    item_image=models.CharField(max_length=5000,null=True,default='https://static.vecteezy.com/system/resources/previews/016/774/561/non_2x/loading-icon-loading-progress-icon-on-transparent-background-free-png.png')

    
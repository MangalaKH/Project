from django.shortcuts import render,redirect
from django.http import HttpResponse
from Foodapp.models import Item
from .forms import ItemForm
from django.contrib.auth.decorators import login_required


# Create your views here.

def hello(request):
    return render(request,'Foodapp/hello.html')

@login_required
def index(request):
    item_list=Item.objects.all()
    context={
        'item_list':item_list,
    }
    return render(request,'Foodapp/index.html',context)

def detail(request,item_id):
    item=Item.objects.get(pk=item_id)
    context={
        'item':item,
    }
    return render(request,'Foodapp/detail.html',context)


def create_item(request):
    form=ItemForm(request.POST or None)
    if form.is_valid():
        form.save()
        return redirect('Foodapp:index')
    return render(request,'Foodapp/item-form.html',{'form':form})


def update_item(request,id):
    item=Item.objects.get(id=id)
    form=ItemForm(request.POST or None,instance=item)
    if form.is_valid():
        form.save()
        return redirect('Foodapp:index')
    return render(request,'Foodapp/item-form.html',{'form':form})


def delete_item(request,id):
    item=Item.objects.get(id=id)
    if request.method=='POST':
        item.delete()
        return redirect('Foodapp:index')
    return render(request,'Foodapp/delete_msg.html',{'item':item})

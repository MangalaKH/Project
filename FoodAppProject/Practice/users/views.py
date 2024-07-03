from django.shortcuts import render,redirect
from django.contrib.auth.forms import UserCreationForm
from .models import Profile
from django.contrib.auth.decorators import login_required
# from django.http import HttpResponse

# Create your views here.
def register(request):
    form=UserCreationForm(request.POST or None)
    if form.is_valid():
        form.save()
        return redirect('login')
    return render(request,'users/register.html',{'form':form})

@login_required
def profile(request):
    profile_instances=Profile.objects.all()
    context={
        'profile_instances':profile_instances,
    }
    # if request.method=='POST':
    #     full_name=request.POST.get('full_name')
    #     profile=Profile(full_name=full_name)
    return render(request,'users/profile.html',context)



#coding=utf-8
# Create your views here.

from django.http import HttpResponse
from django.template import Template, Context
from django.shortcuts import render_to_response
import datetime
from birthday.forms import BirthdayForm
from birthday.models import Birthday

def hello(request):
    return HttpResponse('Hello, Worlp')

def current(request):
    now=datetime.datetime.now()
    return render_to_response('current.html', {'current': now})

def birth(request):
    data=[]
    if request.method == 'POST':
        form=BirthdayForm(request.POST)
        if form.is_valid():
            #add to db
            form.save()
            data=Birthday.objects.all()
    form=BirthdayForm()
    return render_to_response('birthday.html', {'form':form, 'data':data})

import axios from '../../utils/axios'

export function addClassroom(data) {
    return axios.post('/admin/classroom', data)
}

export function getClassroomPage(params) {
    return axios.get('/admin/classroom/page', {
        params: {
            pageNum: params.pageNum || 1,
            pageSize: params.pageSize || 10,
            ...params.query
        }
    });
}

export function removeBatchClassroom(ids) {
    return axios.delete('/admin/classroom/batch', {
        data: ids
    });
} 